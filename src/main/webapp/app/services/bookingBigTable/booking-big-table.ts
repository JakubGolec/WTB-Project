export class BookingBigTable {
  id: bigint;
  startDate: string;
  endDate: string;
  user: {
    id: bigint;
    name: string;
    surname: string;
    nick: string;
    password: string;
    email: string;
  };
  bigTable: {
    id: string;
    isTableBig: boolean;
  };
  game: {
    id: bigint;
    name: string;
    isbigtablerequired: boolean;
  }
}
