import { Customer} from './customer.model';
import { Comment} from './comment.model';
import { Pedido } from './pedido.model';

export interface Product{
    id?: number;
    name: string;
    price: number;
    description: string;
    imageUrl: string;
    label:string;
    pDate:string;
    score:number;
    comments:Comment[];
    idLogged:boolean;
}