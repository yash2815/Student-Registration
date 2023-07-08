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
  selector: 'app-getstudent',
  templateUrl: './getstudent.component.html',
  styleUrls: ['./getstudent.component.css']
})
export class GetstudentComponent {

  constructor(private http: HttpClient) { }

  student : Student ={
    rollNo:'',
    name:'',
    age:0,
    address:'',
    mobileNo:[]
  }
  mess:CustomObject | null = null;
  str:string='';
  rollNo:number = 0;
  show2:boolean = false;
  show1:boolean = false;

  getStudent(): void{
    const url = environment.apiUrl+'/getstudent/'+this.rollNo;

    this.http.get<CustomObject>(url).subscribe(
      (response:CustomObject) => {
        console.log("done");
        this.mess=response
        if(response.statusCode===200){
          this.student = response.data;
          this.show1 = true;
        }else{
          this.str=response.responseMessage;
          this.show2 = true;
          console.log(this.str);
          
        }
        
      },
      (error) => {
        console.error('error');
        
      }
    )
  }

}
