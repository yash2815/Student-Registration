import { Component } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { environment } from 'src/enviroments/enviroment';
import { HttpHeaders } from '@angular/common/http';

interface CustomObject {
  statusCode: number;
  data: any;
  responseMessage: string
}

@Component({
  selector: 'app-deletestudent',
  templateUrl: './deletestudent.component.html',
  styleUrls: ['./deletestudent.component.css']
})

export class DeletestudentComponent {

  constructor(private http: HttpClient) { }

  rollNo : number = 0;
  message:CustomObject | null = null;
  str:string='';

  deleteStudent():void{

    const url = environment.apiUrl+'/deletestudent/'+this.rollNo;

    const headers = new HttpHeaders().set('Accept','application/json');

    this.http.delete<CustomObject>(url,{headers}).subscribe(
      (response:CustomObject) => {
        console.log('success');
        this.message = response;
        this.str=response.responseMessage;
      },
      (error) => {
        console.error('error');
        // this.message=error;
      }
    );
  }

}
