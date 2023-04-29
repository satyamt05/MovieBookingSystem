import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';  
import { Observable } from 'rxjs'; 

@Injectable({
  providedIn: 'root'
})
export class MovieService {
  
  constructor(private http:HttpClient) { }  
  
  getMovieList(): Observable<any> {  
    return this.http.get('http://localhost:8211/movie/movies');  
  }  
  
  addMovie(movie: object): Observable<object> {  
    return this.http.post('http://localhost:8211/movie/movies', movie);  
  }  
  
  deleteMovie(id: number): Observable<any> {  
    return this.http.delete('http://localhost:8211/movie/movies/'+id, { responseType: 'text' });  
  }  
  
  getMovie(id: number): Observable<Object> {  
    return this.http.get('http://localhost:8211/movie/movies/'+id); 
  }  
 
  
  updateMovie(id:number,value:any): Observable<Object> {  
    return this.http.put('http://localhost:8211/movie/movies/'+id, value);  
  }  
    
  checkMovie(id:number) :Observable<any>{
  return this.http.get('http://localhost:8211/movie/checkMovie/'+id, { responseType: 'text' });
  }
}  