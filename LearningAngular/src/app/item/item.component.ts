import { Component, EventEmitter, Input, Output } from '@angular/core';
import { item } from '../Model/item.model';
import { EventType } from '@angular/router';

@Component({
  selector: 'app-item',
  templateUrl: './item.component.html',
  styleUrls: ['./item.component.css'],
})
export class ItemComponent {
  @Input() todoist!: item;

  @Output() eventName = new EventEmitter<item>();

  deleteitem = (todoist: item) => {
    this.eventName.emit(todoist);
    console.log('hello');
  };
}
