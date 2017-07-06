import { Injectable } from '@angular/core';
import { MdSnackBar } from '@angular/material';

@Injectable()
// REVIEW I would rename this to NotificationService abstracting from the concrete representation chosen for this concern.
// After all we might decide to present notification in a different way at some point of time....

// REVIEW s. comment in WindowService
export class SnackBarService {

    constructor(public snackBar: MdSnackBar) { }

    openSnack(message: string, duration: number, color: string): void {
            this.snackBar.open(message, 'OK', {
                duration: duration,
                extraClasses: ['bgc-' + color + '-600'],
            });
    }
}
