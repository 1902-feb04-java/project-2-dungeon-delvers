export class Encounter {
    constructor(
        public id: number,
        public encounterName: string,
        public campaignId: number,
        public userId: number,
        public monsters: string
    ) {}
}