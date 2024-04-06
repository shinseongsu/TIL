import React from 'react';
import {sleep} from "@/lib/utils";

const page = async () => {
    // throw new Error("my error");
    return (
        <div className="min-h-[600px]">
            {" "}
            HomePage
            <div className="h-[500px] bg-neutral-700">HomePage</div>
            <div className="h-[500px] bg-neutral-700">HomePage</div>
            <div className="h-[500px] bg-neutral-700">HomePage</div>
            <div className="h-[500px] bg-neutral-700">HomePage</div>
        </div>
    );
};

export default page;
