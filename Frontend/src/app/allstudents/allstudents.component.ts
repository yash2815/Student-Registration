import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/enviroments/enviroment';

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
  selector: 'app-allstudents',
  templateUrl: './allstudents.component.html',
  styleUrls: ['./allstudents.component.css']
})
export class AllstudentsComponent {

  constructor(private http: HttpClient) { }

  res: CustomObject | null = null;
  students: Student[] = [];
  display:boolean = false;
  str:String='';

  getAllStudents():void {
    this.http.get<CustomObject>(environment.apiUrl + '/allstudents').subscribe(
      (response:CustomObject) => {
        console.log('success');
        this.res = response;
        if(this.res.statusCode===200){
        this.students = response.data;
        this.display= true;
      }else{
        this.str=response.responseMessage;
      }
        
      },
      (error) => {
        console.error('error');
      } 
    )
  }

}
