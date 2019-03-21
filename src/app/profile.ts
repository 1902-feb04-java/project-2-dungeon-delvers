import { Campaign } from "./campaign";

export class Profile 
{
    characters:string[]; //needs to be of character type.
    campaigns:Campaign[]; //needs to be of type Campaign.
    monsters:string[]; // needs to be of type encounter.
    status:boolean; // false == offline, true == online
    username:string;
    id:number;
   
    constructor(ch:string[], ca:Campaign[], m:string[], s:boolean, u:string, id:number){
        this.characters = ch;
        this.campaigns = ca;
        this.monsters = m;
        this.status = s;
        this.username = u;
        this.id = id;
       
    }
}