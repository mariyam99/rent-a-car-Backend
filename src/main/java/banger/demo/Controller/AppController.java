package banger.demo.Controller;

import banger.demo.Entity.User;
import banger.demo.JwtUtil;
import banger.demo.Repo.UserRepo;
import banger.demo.service.UserDetail;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@CrossOrigin(origins = "*",allowedHeaders = "*",methods = {RequestMethod.POST,RequestMethod.GET,RequestMethod.DELETE,RequestMethod.PUT})
public class AppController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserDetail userDetailService;

    @Autowired
    private JwtUtil jwtTokenUtil;

    @Autowired
    UserRepo userRepo;


//    @PostMapping(value = "/authenticate")
//    public ResponseEntity<?> Login(@RequestBody LoginRequest authenticationRequest) {
//      User customer = new User(authenticationRequest.getUsername(),authenticationRequest.getPassword());
//        User user= userRepo.findByUsername(customer.getUsername());
//        if (user.validatePassword(authenticationRequest.getPassword(), user.getPassword())) {
//            return new ResponseEntity<>(user,HttpStatus.OK);
//        }
//        return new ResponseEntity<>("Please Login again",HttpStatus.OK);
//    }


      @PostMapping(value = "/authenticate")
      public ResponseEntity<?> createAuthenticationToken(@RequestBody SignUpRequest authenticationRequest) throws Exception {
        User user=userRepo.findByUsername(authenticationRequest.getUsername());
        if(user.validatePassword(authenticationRequest.getPassword(),user.getPassword())){
            try{
                authenticationManager.authenticate(
                        new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(),
                        user.getPassword()));
            }
            catch (BadCredentialsException exception)
            {
                throw  new Exception("Incorrect username and password",exception);
            }
        }
        final UserDetails userDetail= userDetailService
                .loadUserByUsername(authenticationRequest.getUsername());
        final String jwt= jwtTokenUtil.generateToken(userDetail);
        return ResponseEntity.ok(new LoginResponse(jwt));
      }


          @PostMapping(value = "/findusername")
    public ResponseEntity<String> findusername(@Valid @RequestBody SignUpRequest signUpRequest)
    {
        String usernameResponse = "NON-EXISTS";
        if(userRepo.existsByUsername(signUpRequest.getUsername()))
        {
            usernameResponse="Username is already taken";
            return new ResponseEntity<>(usernameResponse,HttpStatus.OK);
        }
        return new ResponseEntity<>(usernameResponse,HttpStatus.OK);
    }



    @PostMapping("/signup")
    public ResponseEntity<?> registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

      User user =new User(signUpRequest.getUsername(),signUpRequest.getEmail(),new BCryptPasswordEncoder().encode(signUpRequest.getPassword()),signUpRequest.getAge(),
              signUpRequest.getFirstName(),signUpRequest.getLastName(),signUpRequest.getPhone(),signUpRequest.getLicenseNo(),signUpRequest.getNic(),
              signUpRequest.getBlacklisted(),signUpRequest.getRole());
        User result = userRepo.save(user);
        URI location = ServletUriComponentsBuilder
                .fromCurrentContextPath().path("/SignUp/{result}")
                .buildAndExpand(result).toUri();
        return ResponseEntity.created(location).body(new APIResponse(true, "User registered successfully"));
    }

    @PostMapping(value = "/checkprofile")
    public ResponseEntity<?> checkProfile(@Valid @RequestBody LoginRequest Request)
    {
        String username_response = "NOT_AVAILABLE";
        if(userRepo.existsByUsername(Request.getUsername())){
            User user=userRepo.findByUsername(Request.getUsername());
            return new ResponseEntity<>(user,HttpStatus.OK);
    }
        return new ResponseEntity<>(username_response,HttpStatus.OK);
    }

}
