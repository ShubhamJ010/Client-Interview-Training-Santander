export class item {
  id: number;
  title: string;
  dec: string;
  check: boolean;

  constructor(id: number, title: string, dec: string, check: boolean) {
    this.id = id;
    this.title = title;
    this.dec = dec;
    this.check = check;
  }
}
