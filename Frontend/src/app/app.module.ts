import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { AddstudentComponent } from './addstudent/addstudent.component';
import { AllstudentsComponent } from './allstudents/allstudents.component';
import { DeletestudentComponent } from './deletestudent/deletestudent.component';
import { ModifystudentComponent } from './modifystudent/modifystudent.component';
import { GetstudentComponent } from './getstudent/getstudent.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http'; 


@NgModule({
  declarations: [
    AppComponent,
    AddstudentComponent,
    AllstudentsComponent,
    DeletestudentComponent,
    ModifystudentComponent,
    GetstudentComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
