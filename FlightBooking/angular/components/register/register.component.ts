import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit {

  registerForm:FormGroup
  constructor(private fb:FormBuilder,private service:AuthService,private router:Router){
    this.registerForm = this.fb.group({
      email:['',Validators.required],
      password:['',Validators.required],
      username:['',Validators.required],
      mobileNumber:['',Validators.required],
      userRole:['',Validators.required],
    })
  }
  onSubmit(){
    if(this.registerForm.valid){
      let newUser = {
        'email':this.registerForm.value.email,
        'password':this.registerForm.value.password,
        'username':this.registerForm.value.username,
        'mobileNumber':this.registerForm.value.mobileNumber,
        'userRole':this.registerForm.value.userRole,
      }
      this.service.addUser(newUser).subscribe((result)=>{
        this.registerForm.reset()
        alert("Registration successful")
        this.router.navigate(['/login'])
      },
      (error)=>{
        this.registerForm.reset()
        alert("Registration not done")
        this.router.navigate(['/error'],{queryParams:{errorMsg:'Registration not done due to exising emailId'}} )
      });
      
    }
  }
  ngOnInit(): void {
  }

}
