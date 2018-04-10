import { Customer} from './customer.model';
import { Comment} from './comment.model';
import { Product  } from './product.model';

export interface Pedido{
    id?: number;
    totalPrice: number;
    status: string;
    user: string;
    date: string;
    productsofPedido:Product[];
}