import {EventEmitter} from '@angular/core';
import {Error} from './error.model';

export class ErrorService{
	errorOccurred = new EventEmitter<Error>();

	handleError(error:any)
	{
		let msg  = (error.error) ? error.error.message : error.message;
		const errorData = new Error(error.title,msg);
		this.errorOccurred.emit(errorData);
	}
}