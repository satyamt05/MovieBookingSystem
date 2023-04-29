import { Movie } from './movie';
import {Screen } from './screen';

export class Show {
    id:number;
    name:String;
    startTime:String;
    endTime:String;
    availableSeats:number;
    showPrice:number;
    screenId:Screen;
    movieId:Movie;
}
