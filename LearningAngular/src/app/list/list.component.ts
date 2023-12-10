import { Component } from '@angular/core';
import { item } from '../Model/item.model';

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css'],
})
export class ListComponent {
  todoist: item[] = [
    {
      id: 1,
      title: 'Shubham',
      dec: 'loves nicole',
      check: false,
    },
    {
      id: 2,
      title: 'Shubham',
      dec: 'loves nicole',
      check: false,
    },
    {
      id: 3,
      title: 'Shubham',
      dec: 'loves nicole',
      check: false,
    },
  ];
  deteletodo(event: item) {
    const index = this.todoist.findIndex(
      (itemInList) => itemInList.id === event.id
    );

    this.todoist[index].check = !this.todoist[index].check;
    console.log(this.todoist[index]);
  }

  addTodo(event: item) {
    console.log('✌️✌️✌️');
    this.todoist.push(event);
  }
}
