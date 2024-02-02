export type User = {
    id: number;
    username: string;
    edat: number;
    password: string;
    email: string;
}

export const defaultUser: User = {
    id: 0,
    username: "ALEX",
    edat: 20,
    password: "1111",
    email: "edt@edt.org"
};