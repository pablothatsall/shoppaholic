
import { Pedido } from './pedido.model';
import { Comment} from './comment.model';
import { Product  } from './product.model';

export interface Customer {
    idCustomer?: number;
    firstName: string;
    lastName: string;
    mail: string;
    password: string;
    address:string;
    telephone:number;
    imageUrl?: string;
    myOrders:Pedido[];
    myCart:Pedido;
    roles:string[];
    idLogged:boolean;
}