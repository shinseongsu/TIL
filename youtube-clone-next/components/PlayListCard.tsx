"use client";

import React from 'react';
import {Playlist} from "@/types";
import Image from "next/image";
import { getRandomElementFromArray } from '@/lib/utils';
import {useRouter} from "next/navigation";

const PlayListCard = ({playlist}: {playlist: Playlist}) => {
    const {push} = useRouter();
    const { id, owner, playlistName, songList } = playlist;

    const songListLen = songList?.length;
    const imgSrc = getRandomElementFromArray(songList)?.imageSrc;
    const onClickCard = () => {
        push(`/playlist?list=${id}`);
    }

    return (
        <article className="h-[136px] cursor-pointer">
            <section className="relative h-[136px]" onClick={onClickCard}>
                <Image  src={imgSrc} fill={true} alt="thumbnail" className="object-cover" />
            </section>
            <section>
                <div>{playlistName}</div>
                <div className="text-neutral-500">
                    {`${owner} - 트랙 ${songListLen}개`}
                </div>
            </section>
        </article>
    )
}

export default PlayListCard;
