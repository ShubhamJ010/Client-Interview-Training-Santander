import { Component } from '@angular/core';
import { ActivatedRoute } from '@angular/router';

@Component({
  selector: 'app-one',
  templateUrl: './one.component.html',
  styleUrls: ['./one.component.css'],
})
export class OneComponent {
  value: Number;
  constructor(private route: ActivatedRoute) {
    const heroId = this.route.snapshot.paramMap.get('id');
    this.value = Number(heroId ? heroId : '0');
  }
}
