import { Component, EventEmitter, Output } from '@angular/core';
import { item } from '../Model/item.model';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-add-todo',
  templateUrl: './add-todo.component.html',
  styleUrls: ['./add-todo.component.css'],
})
export class AddTodoComponent {
  myform: FormGroup;

  constructor(formBuilder: FormBuilder) {
    this.myform = formBuilder.group({
      title: ['', Validators.required],
      dec: ['', Validators.required],
    });
  }
  @Output() newTodoSend = new EventEmitter<item>();

  cnt: number = 4;
  newTodo: item = {
    id: this.cnt,
    title: '',
    dec: '',
    check: false,
  };

  onSubmit() {
    console.log(this.newTodo);
    this.cnt += 1;
    this.newTodoSend.emit(this.newTodo);
  }
}
