import React, {ReactNode} from 'react';

const layout = ({children}: {children: ReactNode}) => {
    return (
        <div>
            library layout
            {children}
        </div>
    );
};

export default layout;