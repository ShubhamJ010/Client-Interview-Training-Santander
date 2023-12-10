import { Component, OnInit } from '@angular/core';
import {
  AbstractControl,
  FormBuilder,
  FormGroup,
  Validators,
  FormArray,
} from '@angular/forms';

interface UserData {
  email: string;
  password: string;
  emailReq: boolean;
  confirmPassword: string;
}

@Component({
  selector: 'app-reactive-form-group',
  templateUrl: './reactive-form-group.component.html',
  styleUrls: ['./reactive-form-group.component.css'],
})
export class ReactiveFormGroupComponent implements OnInit {
  get altEm() {
    return this.userForm.get('altEmail') as FormArray;
  }
  removeEmail(i: number) {
    this.altEm.removeAt(i);
  }
  addEmail() {
    this.altEm.push(this.fb.control(''));
  }
  userData: UserData;
  userForm!: FormGroup;
  submitted: boolean;
  el: String = 'Email';
  constructor(private fb: FormBuilder) {
    this.userData = {
      email: '',
      emailReq: false,
      password: '',
      confirmPassword: '',
    };
    this.submitted = false;
  }

  confirmingPass = (
    control: AbstractControl
  ): { [key: string]: any } | null => {
    const password = control.get('password')?.value;
    const confirmPassword = control.get('confirmPassword')?.value;
    if (
      control.get('password')?.pristine ||
      control.get('confirmPassword')?.pristine
    )
      return null;
    return password !== confirmPassword ? { passwordMismatch: true } : null;
  };

  isEmail = (con: AbstractControl): { [key: string]: any } | null => {
    const emailRegex = /^[\w-]+(\.[\w-]+)*@([\w-]+\.)+[a-zA-Z]{2,7}$/;

    const isValidEmail = !emailRegex.test(con.value);
    return isValidEmail ? { emailInvalid: { value: con.value } } : null;
  };

  ngOnInit() {
    this.userForm = this.fb.group(
      {
        email: [this.userData.email, []],
        emailReq: [this.userData.emailReq],

        password: [
          this.userData.password,
          [Validators.required, Validators.minLength(3)],
        ],
        confirmPassword: [
          this.userData.confirmPassword,
          [Validators.required, Validators.minLength(3)],
        ],
        altEmail: this.fb.array([]),
      },
      { validator: this.confirmingPass }
    );

    this.userForm.get('emailReq')?.valueChanges.subscribe((data) => {
      if (data) {
        this.el = 'Email';
        this.userForm.get('email')?.setValidators(Validators.required);
        this.userForm.get('email')?.setValidators(Validators.minLength(3));
        this.userForm.get('email')?.setValidators(this.isEmail);
      } else {
        this.userForm.get('email')?.clearValidators;
        this.el = 'Username';
      }
    });
  }

  onSubmit() {
    // Update the userData model with the form values
    this.submitted = true;

    this.userData.email = this.userForm.get('email')?.value;
    this.userData.emailReq = this.userForm.get('emailReq')?.value;
    this.userData.password = this.userForm.get('password')?.value;
    this.userData.confirmPassword = this.userForm.get('confirmPassword')?.value;
  }
}
