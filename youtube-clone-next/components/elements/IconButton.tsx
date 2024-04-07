import React from 'react';

const IconButton = ({ icon, onClickIcon = () => {} }) => {
    return (
        <div>
            <div
                onClick={onClickIcon}
                className="flex justify-center items-center w-[36px] h-[36px] hover:bg-[rgba(144,144,144,0.45)] rounded-full cursor-pointer">
                {icon}
            </div>
        </div>
    );
};

export default IconButton;
