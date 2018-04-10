
import { Pedido } from './pedido.model';
import { Customer} from './customer.model';
import { Product  } from './product.model';

export interface Comment {
    id?:number;
    customer:Customer;
    comment: string;
    date: string;
    product: Product;
    idLogged:boolean;
}