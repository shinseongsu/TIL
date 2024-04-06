"use client";

import React from 'react';
import Image from "next/image";
import { RxHamburgerMenu } from "react-icons/rx";
import {useRouter} from "next/navigation";
import IconButton from "./IconButton";
import {IoCloseOutline} from "react-icons/io5";

const Logo = ({isInDrawer = false, onClickClose = () => {}}) => {
    const { push } = useRouter();
    const onClickLogo = () => {
        // home 으로 이동하는 함수
        push("/");
    }

    return (
        <section className="flex flex-row items-center gap-3">
            <IconButton
                onClickIcon={onClickClose}
                icon={isInDrawer ?
                    (<IoCloseOutline size={30} />) :
                    (<RxHamburgerMenu size={24} />)} />
            <div className="cursor-pointer" onClick={onClickLogo}>
                <Image src={"/main-logo.svg"} width={100} height={30} alt="logo" />
            </div>
        </section>
    )
}

export default Logo;