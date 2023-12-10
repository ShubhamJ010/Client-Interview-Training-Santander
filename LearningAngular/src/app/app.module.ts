import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { ListComponent } from './list/list.component';
import { ItemComponent } from './item/item.component';
import { AddTodoComponent } from './add-todo/add-todo.component';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { HomeComponent } from './routing-learning/home/home.component';
import { OneComponent } from './routing-learning/one/one.component';
import { TwoComponent } from './routing-learning/two/two.component';
import { ThreeComponent } from './routing-learning/three/three.component';
import { FourComponent } from './routing-learning/four/four.component';
import { ReactiveFormGroupComponent } from './reactive-form-group/reactive-form-group.component';


@NgModule({
  declarations: [AppComponent, ListComponent, ItemComponent, AddTodoComponent, HomeComponent, OneComponent, TwoComponent, ThreeComponent, FourComponent, ReactiveFormGroupComponent],
  imports: [BrowserModule, AppRoutingModule, FormsModule, ReactiveFormsModule],
  providers: [],
  bootstrap: [AppComponent],
})
export class AppModule {}
