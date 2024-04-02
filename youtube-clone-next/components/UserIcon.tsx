import React from 'react';
import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";

const UserIcon = () => {
    return (
        <Avatar>
            <AvatarImage src="https://github.com/sadcn.png" />
            <AvatarFallback>CN</AvatarFallback>
        </Avatar>
    )
}

export default UserIcon;