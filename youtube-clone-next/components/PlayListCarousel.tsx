import React from 'react';
import { Playlist } from '@/types';
import {Carousel, CarouselContent, CarouselItem, CarouselNext, CarouselPrevious} from "@/components/ui/carousel";
import PlayListCard from "@/components/PlayListCard";

interface PlayListCarouselProps {
    title: string;
    subTitle?: string;
    Thumbnail?:React.ReactNode;
    playlistArray?: Playlist[];
}

const PlayListCarousel: React.FC<PlayListCarouselProps> = ({
        title,
        subTitle,
        Thumbnail,
        playlistArray,
    }) => {
    return (<div>
        <div className="w-full">
            <Carousel className="w-full max-w-sm">
                <div className="flex flex-row justify-between items-end my-2">
                    <article className="flex flex-row gap-3">
                        {Thumbnail}
                        <div className="flex flex-col justify-center">
                            <div>{subTitle && <div>{subTitle}</div>}</div>
                            <div className="text-[34px] font-bold leading-[34px]">{title}</div>
                        </div>
                    </article>
                    <div className="relative left-[-45px]">
                        <div className="absolute bottom-[20px]">
                            <CarouselPrevious className="right-2" />
                            <CarouselNext className="left-2" />
                        </div>
                    </div>
                </div>

                <CarouselContent>
                    {playlistArray?.map((playlist, index) => {
                        return (
                            <CarouselItem key={index} className="md:basis-1/2 lg:basis-1/3">
                                <PlayListCard playlist={playlist} />
                            </CarouselItem>
                        );
                    })}
                </CarouselContent>
            </Carousel>
        </div>
    </div>);
}

export default PlayListCarousel;