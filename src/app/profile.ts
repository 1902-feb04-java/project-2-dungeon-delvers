import { Campaign } from "./campaign";

export class Profile 
{
    characters:string[]; //needs to be of character type.
    campaigns:Campaign[]; //needs to be of type Campaign.
    encounters:string[]; // needs to be of type encounter.
    status:boolean; // false == offline, true == online
    username:string;
    id:number;
    password:string;
    constructor(ch:string[], ca:Campaign[], e:string[], s:boolean, u:string, id:number, password:string = ""){
        this.characters = ch;
        this.campaigns = ca;
        this.encounters = e;
        this.status = s;
        this.username = u;
        this.id = id;
        this.password = password;
    }
}