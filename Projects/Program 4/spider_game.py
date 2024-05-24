 #####################################################################
# author:       Blair Bourque
# date:         16th March, 2024
# description:  a game where you will control a wizard and shoot at
#               a spider
#####################################################################

#Import constants file
from Constants import *
# Import the pygame module
import pygame
# Import random for random numbers
import random

# Define the Player object extending pygame.sprite.Sprite
# Instead of a surface, we use an image for a better looking sprite
# Define the Player object extending pygame.sprite.Sprite
# Instead of a surface, we use an image for a better looking sprite
class Player(pygame.sprite.Sprite): 
    def __init__(self):
        super(Player, self).__init__()
        self.surf = pygame.image.load("wizard.png").convert_alpha()
        self.surf = pygame.transform.scale(self.surf, (100, 100))
        self.surf.set_colorkey((255, 255, 255), RLEACCEL)
        self.rect = self.surf.get_rect(
            center=((WIDTH/2, HEIGHT))
        )
        # Create a new empty group for the bullets
        self.bullets = pygame.sprite.Group()
        self.score = 0

    # Move the sprite based on keypresses
    def update(self, pressed_keys):
        if pressed_keys[pygame.K_LEFT]:
            self.rect.move_ip(-10, 0)
        if pressed_keys[pygame.K_RIGHT]:
            self.rect.move_ip(10, 0)

        # Keep player on the screen
        if self.rect.left < 0:
            self.rect.left = 0
        elif self.rect.right > WIDTH:
            self.rect.right = WIDTH
        if self.rect.top <= 0:
            self.rect.top = 0
        elif self.rect.bottom >= HEIGHT:
            self.rect.bottom = HEIGHT

    def shoot(self):
        fire = Fire(self.rect.midright)
        self.bullets.add(fire)

    def update_score(self):
        self.score += 1

# Define the Fire object extending pygame.sprite.Sprite
class Fire(pygame.sprite.Sprite):
    def __init__(self, pos):
        super(Fire, self).__init__()
        self.surf = pygame.image.load("fire.png ").convert_alpha()
        self.surf = pygame.transform.scale(self.surf, (50, 50))
        self.surf.set_colorkey((255, 255, 255), RLEACCEL)
        self.rect = self.surf.get_rect(center=pos)
        self.speed = 20

    def update(self):
        self.rect.move_ip(0,-10)
        if self.rect.left > WIDTH:
            self.kill()
        
        # Check for collision with enemy
        collided_enemy = pygame.sprite.spritecollideany(self, enemies)
        if collided_enemy:
            collided_enemy.kill()
            self.kill()
            player.update_score()

class Enemy(pygame.sprite.Sprite):
    def __init__(self):
        super(Enemy, self).__init__()
        self.surf = pygame.image.load("spider.png").convert_alpha()
        self.surf = pygame.transform.scale(self.surf, (100,100))
        # The starting position is randomly generated, as is the speed
        self.rect = self.surf.get_rect(
            center=(0, random.randint(0, HEIGHT-200))
        )
        self.speed = random.randint(5, 8)

    # Move the enemy based on speed
    # Remove it when it passes the left edge of the screen
    def update(self):
        self.rect.move_ip(self.speed, 0)
        if self.rect.center[0] > WIDTH:
            self.kill()
            global lives
            lives -= 1
            if lives == 0:
                pygame.quit()

        
        if pygame.sprite.spritecollideany(self, player.bullets):
            self.kill()
            global score
            score += 1
            
 
# Define the cloud object extending pygame.sprite.Sprite
# Use an image for a better looking sprite
class Wind(pygame.sprite.Sprite):
    def __init__(self):
        super(Wind, self).__init__()
        self.surf = pygame.image.load("wind.png").convert()
        self.surf.set_colorkey((0, 0, 0), RLEACCEL)
        # The starting position is randomly generated
        self.rect = self.surf.get_rect(
            center=(
                random.randint(WIDTH + 20, WIDTH + 100),
                random.randint(0, HEIGHT),
            )
        )

    # Move the cloud based on a constant speed
    # Remove it when it passes the left edge of the screen
    def update(self):
        self.rect.move_ip(-5, 0)
        if self.rect.right < 0:
            self.kill()


# Setup for sounds, defaults are good
pygame.mixer.init()

# Initialize pygame
pygame.init()

# Setup the clock for a decent framerate
clock = pygame.time.Clock()

# Create the screen object
# The size is determined by the constant WIDTH and HEIGHT
screen = pygame.display.set_mode((WIDTH, HEIGHT))

# Create our 'player'
player = Player()

# Create custom events for adding a new enemy and cloud
ADDENEMY = pygame.USEREVENT + 1
pygame.time.set_timer(ADDENEMY, 250)
ADDCLOUD = pygame.USEREVENT + 2
pygame.time.set_timer(ADDCLOUD, 1000)

# Create groups to hold enemy sprites, bullet sprites, and all sprites
enemies = pygame.sprite.Group()
bullets = pygame.sprite.Group()
clouds = pygame.sprite.Group()
all_sprites = pygame.sprite.Group()
all_sprites.add(player)

running = True

##MAIN##
lives = 3
score = 0

while running:
    # Look at every event in the queue
    for event in pygame.event.get():
        # Did the user hit a key?
        if event.type == KEYDOWN:
            # Was it the Escape key? If so, stop the loop
            if event.key == K_ESCAPE:
                running = False
            
            if event.key == K_SPACE:
                player.shoot()

        # Did the user click the window close button? If so, stop the loop
        elif event.type == QUIT:
            running = False

        # Should we add a new enemy?
        elif event.type == ADDENEMY:
            # Create the new enemy, and add it to our sprite groups
            new_enemy = Enemy()
            enemies.add(new_enemy)
            all_sprites.add(new_enemy)

        # Should we add a new cloud?
        elif event.type == ADDCLOUD:
            # Create the new cloud, and add it to our sprite groups
            new_wind = Wind()
            clouds.add(new_wind)
            all_sprites.add(new_wind)

    # Get the set of keys pressed and check for user input
    pressed_keys = pygame.key.get_pressed()
    player.update(pressed_keys)
    player.bullets.update()

    # Update the bullets
    for bullet in player.bullets:
        bullet.update()
        # Check if the bullet has collided with an enemy
        if pygame.sprite.spritecollide(bullet, enemies, True):
            

            score += 1
            
           

            bullet.kill()

    # Update the position of our enemies and clouds
    enemies.update()
    clouds.update()

    # Fill the screen with white
    screen.fill((WHITE))
    pygame.font.init()
    my_font = pygame.font.SysFont('Comic Sans Ms', 15)
    my_font2 = pygame.font.SysFont('Comic Sans Ms', 15)

    text_surface = my_font.render('Lives: ' + str(lives), False, (0,0,0))
    text_surface2 = my_font.render('Score: ' + str(score), False, (0,0,0))

    # Draw all our sprites
    for entity in all_sprites:
        screen.blit(entity.surf, entity.rect)

    screen.blit(text_surface, (130,860))
    screen.blit(text_surface2, (50,860))

    # Draw all sprites onto the screen
    for entity in all_sprites:
        screen.blit(entity.surf, entity.rect)

    # Draw bullets onto the screen
    for bullet in player.bullets:
        screen.blit(bullet.surf, bullet.rect)

    # Flip everything to the display
    pygame.display.flip()

    # Ensure we maintain a 30 frames per second rate
    clock.tick(30)

