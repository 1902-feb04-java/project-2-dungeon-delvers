import { Campaign } from "./campaign";

export class Profile 
{
    characters:String[]; //needs to be of character type.
    campaigns:Campaign[]; //needs to be of type Campaign.
    encounters:String[]; // needs to be of type encounter.
    status:boolean; // false == offline, true == online
    username:String;
    id:number;
    constructor(ch:String[], ca:Campaign[], e:String[], s:boolean, u:String, id:number){
        this.characters = ch;
        this.campaigns = ca;
        this.encounters = e;
        this.status = s;
        this.username = u;
        this.id = id;
    }
}