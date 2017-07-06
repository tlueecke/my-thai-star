import { TdDataTableSortingOrder } from '@covalent/core';
// FILTERS

// REVIEW General remark: why did we introduce differently named transfer structures here?
// Even if we might not have been able to generate them with CobiGen, the naming should be the same correct?
// My guess is that this is due to developing the client separately first, but this makes the
// code hard to follow since one has to look at all the details to catch the complete information flow
// from client to server

// REVIEW I would rename this to MenuFilter so it is more specifed and makes clear what it is for
export class Filter {
    pagination?: Pagination;
    isFav: boolean;
    searchBy: string;
    sort: { name: string, direction: string }[];
    maxPrice: number;
    minLikes: number;
    categories: [{ id: string }];
}

// REVIEW I would name this BookingFilter
export class FilterCockpit {
    pagination?: Pagination;
    sort?: Sorting[];
    bookingDate: string;
    email: string;
    bookingToken: number;
}

export class Pagination {
    size: number;
    page: number;
    total: number;
}

export class Sorting {
    name: string;
    direction: string;
}

// DISHES
export class ExtraInfo {
    id: number;
    name: string;
    price: number;
    selected: boolean;
}

// BOOKING
export class BookingInfo {
    booking: ReservationInfo;
    invitedGuests?: [{email: string}];
}

export class ReservationInfo {
    bookingDate: string;
    name: string;
    email: string;
    // REVIEW is this needed anywhere? Can't find reading references for it...
    bookingType: number;
    assistants?: number;
}

export class FriendsInvite {
    email: string;
    acceptance: string;
}

export class OrderInfo {
    orderLine: OrderLineInfo;
    extras: number[];
}

export class OrderLineInfo {
    dishId: number;
    amount: number;
    comment: string;
}

export class OrderListInfo {
    booking: {bookingToken: string};
    orderLines: OrderInfo[];
}

// LOGIN
export class LoginInfo {
    username: string;
    password: string;
    role: string;
    token?: string;
}

export class Role {
    name: string;
    permission: number;
}
