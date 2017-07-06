import { Injectable } from '@angular/core';

function getWindow (): any {
    return window;
}

@Injectable()
// REVIEW this service is provided by serveral modules without apparent reason 
// I would introduce a CoreModule for such services, which should be an application wide singleton
// This is done actually for several services, where I will just point to here.
export class WindowService {
    get nativeWindow(): any {
        return getWindow();
    }

    responsiveWidth(): string {
       return (getWindow().innerWidth > 800) ? '40%' : '80%';
    }

    reloadWindow(): void {
       getWindow().location.reload();
    }
}
