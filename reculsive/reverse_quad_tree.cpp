char decompressed[MAX_SIZE][MAX_SIZE];

void decompress(string::iterator& it, int y, int x, int size){
    char head = *(it++);
// 기저사례 b w인경우
    if(head == 'b' || head = 'w'){
        for(int dy = 0; dy < size; ++dy){
            for(int dx = 0; dx < size; ++dx){
                decompressed[y+dy][x+dx] = head;
            }
        }
    }
    else{
        half = size / 2 ;
        // 네부분을 나눠서 압출해제 실시
        decompress(it,y,x,half);
        decompress(it,y,x+half,half);
        decompress(it,y+half,x,half);
        decompress(it,y+half,x+half,half);
    }
}

void reverse(string::iterator& it){
    char head = *it;

    ++it;
    if(head=='b'||head=='w'){
        return string(1, head);
    }
    string upperLeft = reverse(it);
    string upperRight = reverse(it);
    string lowerLeft = reverse(it);
    string lowerRight = reverse(it);

    return string("x") + lowerLeft + lowerRight + upperLeft + upperRight;
}