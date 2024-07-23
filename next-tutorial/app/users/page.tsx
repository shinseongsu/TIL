'use client'

import {useEffect, useState} from "react";
import {searchUsers} from "@/app/actions/user-actions";

export default function UsersPage() {
    const [users, setUsers] = useState([]);

    // useEffect(() => {
    //     fetch(`/api/users?name=${"Alice"}`)
    //         .then(res => res.json())
    //         .then(data => setUsers(data.users));
    // }, []);

    // server actions
    useEffect(() => {
        searchUsers('Alice')
            .then(data => setUsers(data));
    }, []);

    return <main>
        <h1>Users</h1>

        {users.map(user => (
            <p>{user.name}</p>
        ))}
    </main>
}
