import { Profile } from "./profile";

export class Campaign{
    owner:number 
    public players:String[] //needs to be type character
    name:String //campaign name
    id:number
    saveState:String = ""
    constructor(o:number, p:String[], n:String, id:number) {
        this.owner = o;
        this.players = p;
        this.name = n;
        this.id = id;
        
    };
}