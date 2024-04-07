export interface Song {
    name: string;
    channelId: number;
    channel: string;
    src: string;
    imageSrc: string;
}

export interface ToSong extends Song {
    preRank: number;
    rank: number;
}

export interface Playlist {
    id: number;
    owner: string;
    playlistName: string;
    songList: Song[];
}

export interface Channel {
    id: number;
    subscribers: number;
    name: string;
    songList: Song[];
    playlistArray: Playlist[];
}
