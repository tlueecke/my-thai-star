import { environment } from './../environments/environment';

export const config: any = {
    pageSizes: [8, 16, 24],
    roles: [
        {name: 'CUSTOMER', permission: 0},
        {name: 'WAITER', permission: 1},
    ],
};
