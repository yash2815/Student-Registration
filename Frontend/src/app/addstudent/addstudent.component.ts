import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/enviroments/enviroment';
import { HttpHeaders } from '@angular/common/http';
interface Student {
  rollNo: string;
  name:string;
  age:number;
  address:string;
  mobileNo : string[]
}
interface CustomObject {
  statusCode: number;
  data: any;
  responseMessage: string
}

@Component({
  selector: 'app-addstudent',
  templateUrl: './addstudent.component.html',
  styleUrls: ['./addstudent.component.css']
})

export class AddstudentComponent {
  
  constructor(private http: HttpClient) { }

  flag:boolean=false;
  message: CustomObject | null = null;
  str : string='';


 
  student : Student ={
    rollNo:'',
    name:'',
    age:0,
    address:'',
    mobileNo:[]
  }



  // addMobile():void{
  //   this.student.mobileNo.push('');
  // }

  // removeMobile(index:number):void{
  //   this.student.mobileNo.splice(index,1);
  // }

  onsubmit() : void{
    
    const url = environment.apiUrl+'/addstudent';

    const headers = new HttpHeaders().set('Accept', 'application/json, application/*+json');

    this.http.post<CustomObject>(url, this.student, {headers}).subscribe(
      (response:CustomObject) => {
        console.log('success');
        this.message = response;
        this.str=response.responseMessage;
        console.log(this.message.responseMessage)
        this.flag=true;
      },
      (error)=>{
        console.error('error');
      }
      )
  }
}
