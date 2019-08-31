import { Injectable } from '@angular/core';
import { Owner } from './../moudle/owner';
import { Output } from './../moudle/output';
import { HttpClient } from '@angular/common/http';
import { Observable, of } from 'rxjs';
import { catchError, map, tap } from 'rxjs/operators';

@Injectable({
  providedIn: 'root'
})
export class PetService {

  constructor(private http: HttpClient) { }

  private petUrl = 'https://5c92dbfae7b1a00014078e61.mockapi.io/owners';
  private outputArry: Output[] = [];
  private malePets: string[] = [];
  private femalePets: string[] = [];

  getOutput(): Observable<Output[]> {
    return this.http.get<Owner[]> (this.petUrl)
      .pipe(
        map(owners => this.handleOwners(owners)),
        catchError(this.handleError<Output[]>('Get result', []))
      );
  }

  handleOwners(ownersParm: Owner[]): Output[] {
    this.outputArry = [];
    this.malePets = [];
    this.femalePets = [];

    for (const owner of ownersParm) {
      if (owner.pets !== null) {
        for (const pet of owner.pets) {
          if (owner.gender.toUpperCase() === 'MALE' && pet.type.toUpperCase() === 'CAT') {
            this.malePets.push(pet.name);
          }

          if (owner.gender.toUpperCase() === 'FEMALE' && pet.type.toUpperCase() === 'CAT') {
            this.femalePets.push(pet.name);
          }
        }
      }
    }

    const outputMale: Output = {gender: 'Male', petName: this.malePets.sort()};
    this.outputArry.push(outputMale);
    const outputFemale: Output = {gender: 'Female', petName: this.femalePets.sort()};
    this.outputArry.push(outputFemale);

    return this.outputArry;
  }

  private handleError<T>(operation = 'operation', result?: T) {
    return (error: any): Observable<T> => {
      console.error(error);
      return of(result as T);
    };
  }
}
