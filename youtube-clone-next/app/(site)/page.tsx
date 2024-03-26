import React from 'react';
import {sleep} from "@/lib/utils";

const page = async () => {
    console.log('before homePage sleep....');
    await sleep(4000);
    console.log('after homePage sleep....');

    // throw new Error("my error");
    return <div>HomePage</div>;
};

export default page;
