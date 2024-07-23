'use server';

export async function searchUsers(name: string) {
    const DB = [
        { id: 1, name: "Alice" },
        { id: 2, name: "Bob" },
        { id: 3, name: "Charlie" }
    ];

    return DB.filter((user) => user.name.includes(name));
}
