package com.example.work;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/***
 *
 * Запросы
 *
 */
@RestController
public class PromoController {
    private final PromotionRepository repository;
    private final ParticipantRepository participantRepository;
    private final PrizeRepository prizeRepository;

    public PromoController(PromotionRepository repository, ParticipantRepository participantRepository, PrizeRepository prizeRepository) {
        this.repository = repository;
        this.participantRepository = participantRepository;
        this.prizeRepository = prizeRepository;
    }
    /***
     *
     * Добавление промоакции с возможностью указания названия (name), описания (description)
     *
     */

    @GetMapping("/promo")
    List<Promotion> all() {
        return repository.findAllEmpty();
    }
    /***
     *
     * Получение краткой информации (без информации об участниках и призах) обо всех промоакциях
     *
     */
    @PostMapping("/promo")
    Promotion createPromotion(@RequestBody Promotion newPromotion) {

        return repository.save(newPromotion);
    }
    /***
     *
     * Получение полной информации (с информацией об участниках и призах) о промоакции по идентификатору
     *
     */
    @GetMapping("/promo/{id}")
    Promotion getPromotion(@PathVariable Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException ());
    }
    /***
     *
     * Редактирование промо-акции по идентификатору промо-акции
     *
     */
    @PutMapping("/promo/{id}")
    Promotion replaceEmployee(@RequestBody Promotion newPromotion, @PathVariable Long id) {

        return repository.findById(id)
                .map(promotion -> {
                    promotion.setName(newPromotion.getName());
                    promotion.setDescription(newPromotion.getDescription());
                    return repository.save(newPromotion);
                })
                .orElseGet(() -> {
                    newPromotion.setId(id);
                    return repository.save(newPromotion);
                });
    }
    /***
     *
     * Удаление промоакции по идентификатору
     *
     */
    @DeleteMapping("/promo/{id}")
    void deletePromotion(@PathVariable Long id) {
        repository.deleteById(id);
    }
    /***
     *
     * Добавление участника в промоакцию по идентификатору промоакции
     *
     */
    @PostMapping("/promo/{id}/participant")
    String addParticipantToPromotion(@PathVariable Long id,@RequestBody Participant newParticipant) {
        repository.findById(id)
                .map(promotion -> {
                    promotion.setParticipantsOne(newParticipant);
                    return repository.save(promotion);
                }).orElseThrow(() -> new RuntimeException ());

     return     participantRepository.save(newParticipant).getId();

    }
    /***
     *
     * Удаление участника из промоакции по идентификаторам промоакции и участника
     *
     */
    @DeleteMapping("/promo/{id}/participant/{participantId}")
    void deleteParticipant(@PathVariable Long id, @PathVariable Long participantId) {
        repository.findById(id)
                .map(promotion -> {
                    List<Participant> participants = promotion.getParticipants();
                    Participant p = participants.stream()
                            .filter(customer -> participantId.equals(customer.getId()))
                            .findFirst()
                            .orElse(null);
                    participants.remove(p);
                    promotion.setParticipants(participants);
                    promotion.setParticipants(null);
                     repository.save(promotion);
                    return null;
                }).orElseThrow(() -> new RuntimeException ());

    }
    /***
     *
     * Добавление приза в промоакцию по идентификатору промоакции
     *
     */
    @PostMapping("/promo/{id}/prize")
    String addPrizeToPromotion(@PathVariable Long id,@RequestBody Prize newPrize) {

        repository.findById(id)
                .map(promotion -> {
                    promotion.setPrizesOne(newPrize);
                    return repository.save(promotion);
                }).orElseThrow(() -> new RuntimeException ());

        return   prizeRepository.save(newPrize).getId();
    }
    /***
     *
     * Удаление приза из промоакции по идентификаторам промоакции и приза
     *
     */
    @DeleteMapping("/promo/{promoId}}/prize/{prizeId")
    void deletePrize(@PathVariable Long promoId, @PathVariable Long prizeId) {
        repository.findById(promoId)
                .map(promotion -> {
                    List<Prize> prize = promotion.getPrizes();
                    Prize p = prize.stream()
                            .filter(customer -> prizeId.equals(customer.getId()))
                            .findFirst()
                            .orElse(null);
                    prize.remove(p);
                    promotion.setPrizes(prize);
                    repository.save(promotion);
                    return null;
                }).orElseThrow(() -> new RuntimeException ());
    }

}
