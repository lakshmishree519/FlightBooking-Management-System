import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { AuthService } from 'src/app/service/auth.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  loginForm:FormGroup
  constructor(private fb:FormBuilder,private service:AuthService,private router:Router){
    this.loginForm = this.fb.group({
      email:['',Validators.required],
      password:['',Validators.required]
    })
  }
  onSubmit(){
    if(this.loginForm.valid){
      let newUser = {
        'email':this.loginForm.value.email,
        'password':this.loginForm.value.password
      }
      this.service.loginUser(newUser).subscribe((result)=>{
        let res = result
        console.log(res)
        sessionStorage.setItem("email" , this.loginForm.value.email)
        sessionStorage.setItem("role" , res.userRole)
        sessionStorage.setItem("userId", res.userId+"")
        this.loginForm.reset()
        this.router.navigate(['/'])
      },(error)=>{
        alert("User not found")
        this.loginForm.reset()
      })
    }
  }
  ngOnInit(): void {
  }

}