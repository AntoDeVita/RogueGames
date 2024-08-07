const initSlider = () => {
    // Select all slider containers and initialize each slider
    document.querySelectorAll('.slider-wrapper').forEach(sliderWrapper => {
        const imageList = sliderWrapper.querySelector('.slider-content');
        const slideButtons = sliderWrapper.querySelectorAll('.slide-button');
        const sliderScrollbar = sliderWrapper.querySelector('.slider-bar');
        const scrollbarThumb = sliderScrollbar ? sliderScrollbar.querySelector('.scrollbar-thumb') : null;

        console.log("Initializing slider...");
        console.log("imageList:", imageList);
        console.log("slideButtons:", slideButtons);
        console.log("sliderScrollbar:", sliderScrollbar);
        console.log("scrollbarThumb:", scrollbarThumb);

        if (!imageList || slideButtons.length === 0 || !sliderScrollbar || !scrollbarThumb) {
            return;
        }

        const maxScrollLeft = imageList.scrollWidth - imageList.clientWidth;

        scrollbarThumb.addEventListener('mousedown', (e) => {
            const startX = e.clientX;
            const thumbPosition = scrollbarThumb.offsetLeft;

            const handleMouseMove = (e) => {
                const deltaX = e.clientX - startX;
                const newThumbPosition = thumbPosition + deltaX;
                const maxThumbPosition = sliderScrollbar.getBoundingClientRect().width - scrollbarThumb.offsetWidth;

                const boundedPosition = Math.max(0, Math.min(maxThumbPosition, newThumbPosition));
                const scrollPosition = (boundedPosition / maxThumbPosition) * maxScrollLeft;

                scrollbarThumb.style.left = `${boundedPosition}px`;
                imageList.scrollLeft = scrollPosition;
            };

            const handleMouseUp = () => {
                document.removeEventListener('mousemove', handleMouseMove);
                document.removeEventListener('mouseup', handleMouseUp);
            };

            document.addEventListener('mousemove', handleMouseMove);
            document.addEventListener('mouseup', handleMouseUp);
        });

        slideButtons.forEach(button => {
            button.addEventListener('click', () => {
                const direction = button.id.includes('prev') ? -1 : 1;
                const scrollAmount = imageList.clientWidth * direction;
                imageList.scrollBy({ left: scrollAmount, behavior: 'smooth' });
            });
        });

        const handleSlideButtons = () => {
            slideButtons[0].style.display = imageList.scrollLeft <= 0 ? 'none' : 'block';
            slideButtons[1].style.display = imageList.scrollLeft >= maxScrollLeft ? 'none' : 'block';
        };

        const updateScrollThumbPosition = () => {
            const scrollPosition = imageList.scrollLeft;
            const thumbPosition = (scrollPosition / maxScrollLeft) * (sliderScrollbar.clientWidth - scrollbarThumb.offsetWidth);
            scrollbarThumb.style.left = `${thumbPosition}px`;
        };

        imageList.addEventListener('scroll', () => {
            handleSlideButtons();
            updateScrollThumbPosition();
        });

        // Initialize the buttons and scrollbar position on load
        handleSlideButtons();
        updateScrollThumbPosition();
    });
};

window.addEventListener('load', initSlider);