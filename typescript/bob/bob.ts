class Bob {
    hey( message: string ) {
        if (message.match(/^\s*$/)) {
            return 'Fine. Be that way!'
        } else if (message.match(/^[\xdc\xc4\%\^\*\@\#\$\(A-Z\s\,1-9\!]{2,}[\!\?]$/) || message.match(/^[A-Z\s]+$/)) {
            return 'Whoa, chill out!'
        } else if (message.match(/\?$/)) {
            return 'Sure.'
        } else {
            return 'Whatever.'
        }
    }
}

export default Bob
