import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/enviroments/enviroment';
import {HttpHeaders} from '@angular/common/http'

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
  selector: 'app-modifystudent',
  templateUrl: './modifystudent.component.html',
  styleUrls: ['./modifystudent.component.css']
})
export class ModifystudentComponent {

  message:CustomObject | null = null;
  responseMessage: string = '';
  
  constructor(private http: HttpClient) { }

  student : Student ={
    rollNo:'',
    name:'',
    age:0,
    address:'',
    mobileNo:[]
  }

  onsubmit() : void{
    
    const url = environment.apiUrl+'/modifystudent';

    const headers = new HttpHeaders().set('Accept','application/json');

    this.http.put<CustomObject>(url,this.student, {headers}).subscribe(
      (response: CustomObject) => {
        console.log('success');
        this.message = response;
        this.responseMessage = response.responseMessage;
      },
      (error)=>{
        console.error('error');
      }
      )
}

}
