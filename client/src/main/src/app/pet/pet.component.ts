import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http'; // Import HttpClient
import { PetService } from './../service/pet.service';
import { Output } from './../moudle/output';

@Component({
  selector: 'app-pet',
  templateUrl: './pet.component.html',
  styleUrls: ['./pet.component.css']
})
export class PetComponent implements OnInit {
  constructor(private petService: PetService) { }

  petListByGender: Output[];

  ngOnInit() {
    this.getPetListByGender();
  }

  getPetListByGender(): void {
    this.petService.getOutput()
      .subscribe(result => this.petListByGender = result);
  }

}
