import { Observable } from 'rxjs/Observable';
import { Injectable } from '@angular/core';
import { OrderDataService } from '../../shared/backend/order/order-data-service';
import { SnackBarService } from '../../shared/snackService/snackService.service';
import { OrderView, ExtraView } from '../../shared/viewModels/interfaces';
import { OrderListInfo, OrderInfo } from '../../shared/backend/backendModels/interfaces';
import { find, filter, isEqual, remove, cloneDeep, toString } from 'lodash';

const isOrderEqual: Function =
   (orderToFind: OrderView) => (o: OrderView) => o.dish.name === orderToFind.dish.name && isEqual(o.extras, orderToFind.extras);

@Injectable()
export class SidenavService {

  opened: boolean = false;

  orders: OrderView[] = [];

  constructor(private orderDataService: OrderDataService) {}

  public openSideNav(): void {
    this.opened = true;
  }

  public closeSideNav(): void {
    this.opened = false;
  }

  public getOrderData(): any[] {
    return this.orders;
  }

  public getNumberOrders(): number {
    return this.orders.length;
  }

  public findOrder(order: OrderView): OrderView {
    return find(this.orders, isOrderEqual(order));
  }

  public addOrder(order: OrderView): void {
    let addOrder: OrderView = cloneDeep(order);
    addOrder.extras = filter(addOrder.extras, (extra: ExtraView) => extra.selected);
    if (this.findOrder(addOrder)) {
      this.increaseOrder(addOrder);
    } else {
      this.orders.push(addOrder);
    }
  }

  public increaseOrder(order: OrderView): number {
    return this.findOrder(order).orderLine.amount += 1;
  }

  public decreaseOrder(order: OrderView): number {
    return this.findOrder(order).orderLine.amount -= 1;
  }

  public removeOrder(order: OrderView): OrderView {
    return remove(this.orders, isOrderEqual(order));
  }

  public removeAllOrders(): OrderView[] {
    this.orders = [];
    return this.orders;
  }

  public sendOrders(token: string): Observable<number> {

    let orderList: OrderListInfo = {
      booking: {bookingToken: token},
      orderLines: this.composeOrders(this.orders),
    };

    this.closeSideNav();
    return this.orderDataService.saveOrders(orderList);
  }

   composeOrders(orders: OrderView[]): OrderInfo[] {
      let composedOrders: OrderInfo[] = [];
      orders.forEach( (order: OrderView) => {
        let extras: any[] = [];
        order.extras.filter( (extra: ExtraView) => extra.selected )
                    .forEach( (extra: ExtraView) => extras.push({id: extra.id}));
        composedOrders.push({
          orderLine: {
            dishId: order.dish.id,
            amount: order.orderLine.amount,
            comment: order.orderLine.comment,
          },
          extras: extras,
        });
      });
      return composedOrders;
   }
}
